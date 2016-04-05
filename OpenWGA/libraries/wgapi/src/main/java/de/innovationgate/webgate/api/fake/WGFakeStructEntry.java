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
package de.innovationgate.webgate.api.fake;

import de.innovationgate.webgate.api.WGBackendException;
import de.innovationgate.webgate.api.WGDatabase;
import de.innovationgate.webgate.api.WGDocument;
import de.innovationgate.webgate.api.WGIllegalArgumentException;
import de.innovationgate.webgate.api.WGStructEntry;
import de.innovationgate.webgate.api.WGSystemException;

public class WGFakeStructEntry extends WGFakeDocument {

	private Object key;

	public WGFakeStructEntry (WGDatabase db, Object key) {
		super(db, WGDocument.TYPE_STRUCTENTRY);
		this.key = key;
	}

	/**
	 * @throws WGIllegalArgumentException 
	 * @throws WGSystemException 
	 * @throws WGBackendException 
	 * @see de.innovationgate.webgate.api.WGDocumentCore#getMetaData(String)
	 */
	public Object getMetaData(String type) throws WGSystemException, WGIllegalArgumentException, WGBackendException {
	
		if (type.equals(WGStructEntry.META_AREA)) {
			return "__fake_area";
		}
		else if (type.equals(WGStructEntry.META_CONTENTTYPE)) {
			return "__fake_contenttype";
		}
		else if (type.equals(WGStructEntry.META_KEY)) {
		    return key;
		}
		else if (type.equals(WGStructEntry.META_TITLE)) {
		    return "Fake structentry";
		}
		else {
			return super.getMetaData(type);
		}
 
	}

	/* (Kein Javadoc)
	 * @see de.innovationgate.webgate.api.WGDocumentCore#isTemporary()
	 */
	public boolean isTemporary() {
		return true;
	}
}
