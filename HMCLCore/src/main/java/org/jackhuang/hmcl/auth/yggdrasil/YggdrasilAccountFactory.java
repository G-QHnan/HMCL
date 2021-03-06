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
package org.jackhuang.hmcl.auth.yggdrasil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.jackhuang.hmcl.auth.AccountFactory;
import org.jackhuang.hmcl.util.Lang;
import static org.jackhuang.hmcl.auth.yggdrasil.YggdrasilAccount.*;
import org.jackhuang.hmcl.util.UUIDTypeAdapter;

/**
 *
 * @author huangyuhui
 */
public final class YggdrasilAccountFactory extends AccountFactory<YggdrasilAccount> {
    public static final YggdrasilAccountFactory INSTANCE = new YggdrasilAccountFactory();

    private YggdrasilAccountFactory() {
    }

    @Override
    public YggdrasilAccount fromUsername(String username, String password) {
        YggdrasilAccount account = new YggdrasilAccount(username);
        account.setPassword(password);
        return account;
    }

    @Override
    public YggdrasilAccount fromStorage(Map<Object, Object> storage) {
        String username = Lang.get(storage, STORAGE_KEY_USER_NAME, String.class)
                .orElseThrow(() -> new IllegalArgumentException("storage does not have key " + STORAGE_KEY_USER_NAME));

        YggdrasilAccount account = new YggdrasilAccount(username);
        account.setUserId(Lang.get(storage, STORAGE_KEY_USER_ID, String.class, username));
        account.setAccessToken(Lang.get(storage, STORAGE_KEY_ACCESS_TOKEN, String.class, null));
        account.setClientToken(Lang.get(storage, STORAGE_KEY_CLIENT_TOKEN, String.class)
                .orElseThrow(() -> new IllegalArgumentException("storage does not have key " + STORAGE_KEY_CLIENT_TOKEN)));

        Lang.get(storage, STORAGE_KEY_USER_PROPERTIES, List.class)
                .ifPresent(account.getUserProperties()::fromList);
        Optional<String> profileId = Lang.get(storage, STORAGE_KEY_PROFILE_ID, String.class);
        Optional<String> profileName = Lang.get(storage, STORAGE_KEY_PROFILE_NAME, String.class);
        GameProfile profile = null;
        if (profileId.isPresent() && profileName.isPresent()) {
            profile = new GameProfile(UUIDTypeAdapter.fromString(profileId.get()), profileName.get());
            Lang.get(storage, STORAGE_KEY_PROFILE_PROPERTIES, List.class)
                    .ifPresent(profile.getProperties()::fromList);
        }
        account.setSelectedProfile(profile);
        return account;
    }

}
