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
package de.innovationgate.webgate.api.modules;

import de.innovationgate.webgate.api.modules.auth.FileAuthenticationModuleDefinition;
import de.innovationgate.webgate.api.modules.dbs.BeanAdapterModuleDefinition;
import de.innovationgate.webgate.api.modules.dbs.GenericCSDatabaseOptions;
import de.innovationgate.webgate.api.modules.dbs.RSSConnectorModuleDefinition;
import de.innovationgate.webgate.api.modules.servers.OtherSourcesServerModuleDefinition;
import de.innovationgate.webgate.api.modules.wfengines.DefaultWorkflowEngineModuleDefinition;
import de.innovationgate.wga.modules.ModuleRegistrar;
import de.innovationgate.wga.modules.ModuleRegistry;

public class WGAPIRegistrar implements ModuleRegistrar {

    public void registerModules(ModuleRegistry registry) {

        // Database Servers
        registry.addModuleDefinition(new OtherSourcesServerModuleDefinition());
        
        // Content Databases
        registry.addModuleDefinition(new RSSConnectorModuleDefinition());
        registry.addModuleDefinition(new BeanAdapterModuleDefinition());
        
        // Authentication modules
        registry.addModuleDefinition(new FileAuthenticationModuleDefinition());
        
        // Generic content store (for WGA5 admin database showing options on database/global level)
        registry.addModuleDefinition(new GenericCSDatabaseOptions());
        
        // Workflow Engines
        registry.addModuleDefinition(new DefaultWorkflowEngineModuleDefinition());
        
        // Other stuff
        registry.addModuleDefinition(new DefaultPageRightsFilterModuleDefinition());
    }

}
