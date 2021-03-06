/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2017  huangyuhui <huanghongxun2008@126.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.ui.download

import com.jfoenix.controls.JFXListView
import com.jfoenix.controls.JFXSpinner
import javafx.fxml.FXML
import javafx.scene.layout.StackPane
import org.jackhuang.hmcl.download.DownloadProvider
import org.jackhuang.hmcl.download.RemoteVersion
import org.jackhuang.hmcl.task.Scheduler
import org.jackhuang.hmcl.task.Schedulers
import org.jackhuang.hmcl.task.TaskExecutor
import org.jackhuang.hmcl.ui.animation.ContainerAnimations
import org.jackhuang.hmcl.ui.animation.TransitionHandler
import org.jackhuang.hmcl.ui.loadFXML
import org.jackhuang.hmcl.ui.wizard.Refreshable
import org.jackhuang.hmcl.ui.wizard.WizardController
import org.jackhuang.hmcl.ui.wizard.WizardPage
import org.jackhuang.hmcl.util.onChange

class VersionsPage(private val controller: WizardController, private val gameVersion: String, private val downloadProvider: DownloadProvider, private val libraryId: String, private val callback: () -> Unit): StackPane(), WizardPage, Refreshable {

    @FXML lateinit var list: JFXListView<VersionsPageItem>
    @FXML lateinit var spinner: JFXSpinner

    val transitionHandler = TransitionHandler(this)
    private val versionList = downloadProvider.getVersionListById(libraryId)
    private var executor: TaskExecutor? = null

    init {
        loadFXML("/assets/fxml/download/versions.fxml")
        children.setAll(spinner)
        list.selectionModel.selectedItemProperty().onChange {
            controller.settings[libraryId] = it!!.remoteVersion.selfVersion
            callback()
        }
        refresh()
    }

    override fun refresh() {
        executor = versionList.refreshAsync(downloadProvider).subscribe(Schedulers.javafx()) {
            val versions = ArrayList(versionList.getVersions(gameVersion))
            versions.sortWith(RemoteVersion.RemoteVersionComparator.INSTANCE)
            for (version in versions) {
                list.items.add(VersionsPageItem(version))
            }

            transitionHandler.setContent(list, ContainerAnimations.FADE.animationProducer)
        }
    }

    override val title: String
        get() = "Choose a game version"

    override fun cleanup(settings: MutableMap<String, Any>) {
        settings.remove(libraryId)
        executor?.cancel()
    }
}