/*
 * Hello Minecraft!.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
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
package org.jackhuang.hellominecraft.util.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.jackhuang.hellominecraft.util.logging.HMCLog;
import org.jackhuang.hellominecraft.util.EventHandler;
import org.jackhuang.hellominecraft.util.code.Charsets;

/**
 *
 * @author huangyuhui
 */
public class ProcessThread extends Thread {

    JavaProcess p;

    public final EventHandler<String> printlnEvent = new EventHandler<>(this);
    public final EventHandler<JavaProcess> stopEvent = new EventHandler<>(this);

    public ProcessThread(JavaProcess process) {
        p = process;
    }

    public JavaProcess getProcess() {
        return p;
    }

    @Override
    public void run() {
        setName("ProcessMonitor");
        BufferedReader br = null;
        try {
            InputStream in = p.getRawProcess().getInputStream();
            br = new BufferedReader(new InputStreamReader(in, Charsets.toCharset()));

            String line;
            while (p.isRunning())
                while ((line = br.readLine()) != null) {
                    printlnEvent.execute(line);
                    System.out.println("Minecraft: " + line);
                    p.getStdOutLines().add(line);
                }
            while ((line = br.readLine()) != null) {
                printlnEvent.execute(line);
                System.out.println("Minecraft: " + line);
                p.getStdOutLines().add(line);
            }
            if (p.getProcessManager() != null)
                p.getProcessManager().onProcessStopped(p);
            stopEvent.execute(p);
        } catch (IOException e) {
            HMCLog.err("An error occured when reading process stdout/stderr.", e);
        } finally {
            IOUtils.closeQuietly(br);
        }
    }
}
