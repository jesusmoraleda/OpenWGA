/*******************************************************************************
 * Copyright 2009, 2010 Innovation Gate GmbH. All Rights Reserved.
 * 
 * This file is part of the OpenWGA server platform.
 * 
 * OpenWGA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * In addition, a special exception is granted by the copyright holders
 * of OpenWGA called "OpenWGA plugin exception". You should have received
 * a copy of this exception along with OpenWGA in file COPYING.
 * If not, see <http://www.openwga.com/gpl-plugin-exception>.
 * 
 * OpenWGA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OpenWGA in file COPYING.
 * If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package de.innovationgate.wgpublisher.modules.serveroptions;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

import de.innovationgate.utils.WGUtils;
import de.innovationgate.wga.config.WGAConfiguration;
import de.innovationgate.wga.modules.LocalisationBundleLoader;
import de.innovationgate.wga.modules.ModuleDefinition;
import de.innovationgate.wga.modules.ModuleDependencyException;
import de.innovationgate.wga.modules.ModuleType;
import de.innovationgate.wga.modules.OptionDefinitionsMap;
import de.innovationgate.wga.modules.options.ConvertingOptionType;
import de.innovationgate.wga.modules.options.LocalizedOptionDefinition;
import de.innovationgate.wga.modules.options.OptionConversionException;
import de.innovationgate.wga.modules.options.OptionValueProvider;
import de.innovationgate.wga.modules.options.OptionValueValidationException;
import de.innovationgate.wga.modules.options.StringOptionType;
import de.innovationgate.wga.modules.options.URLOptionType;
import de.innovationgate.wga.modules.options.ValidationContext;
import de.innovationgate.wga.modules.types.WGAServerOptionsModuleType;

public class BasicModuleDefinition implements ModuleDefinition {
    
    protected LocalisationBundleLoader _bundleLoader = new LocalisationBundleLoader(WGUtils.getPackagePath(getClass()) + "/basic", getClass().getClassLoader());

    public String getDescription(Locale locale) {
        return _bundleLoader.getBundle(locale).getString("options.description");
    }

    public Class<? extends Object> getImplementationClass() {
        return getClass();
    }

    public Class<? extends ModuleType> getModuleType() {
        return WGAServerOptionsModuleType.class;
    }

    public OptionDefinitionsMap getOptionDefinitions() {
        
        OptionDefinitionsMap options = new OptionDefinitionsMap();
        
        LocalizedOptionDefinition serverName = new LocalizedOptionDefinition(WGAConfiguration.SERVEROPTION_SERVER_NAME, StringOptionType.INSTANCE, _bundleLoader);
        String defaultName;
        try {
            defaultName = InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch (UnknownHostException e) {
            defaultName = "(unknown)";
        }
        serverName.setDefaultValue(defaultName);
        options.addOption(serverName);
        
        LocalizedOptionDefinition rootURL = new LocalizedOptionDefinition(WGAConfiguration.SERVEROPTION_ROOT_URL, new URLOptionType(), _bundleLoader);
        String defaultURL;
        try {
        	defaultURL = "http://" + InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch (UnknownHostException e) {
        	defaultURL = "http://localhost";
        }
        rootURL.setDefaultValue(defaultURL);
        
        options.addOption(rootURL);
        
        return options;
        
    }

    public Object getProperties() {
        return null;
    }

    public String getTitle(Locale locale) {
        return _bundleLoader.getBundle(locale).getString("options.title");
    }

    public void testDependencies() throws ModuleDependencyException {
    }

}
