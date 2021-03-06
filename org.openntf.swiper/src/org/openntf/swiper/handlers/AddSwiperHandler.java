/*******************************************************************************
 * Copyright 2017 Cameron Gregor (http://camerongregor.com) 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License
 *******************************************************************************/
package org.openntf.swiper.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.openntf.swiper.util.SwiperUtil;

import com.ibm.designer.domino.team.action.AbstractTeamHandler;
import com.ibm.designer.domino.team.util.SyncUtil;

public class AddSwiperHandler extends AbstractTeamHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		processSelectedProject(HandlerUtil.getCurrentSelection(event));

		if (this.desProject != null) {		
			
			if (!SyncUtil.isConfiguredForSourceControl(desProject)) {
				
				String title = "Configure Project for Source Control";
				String message = "You must configure the project for Source Control control before adding swiper";
				
				MessageDialog.openInformation(getShell(), title, message);
				
				return null;
				
			}
			
			SwiperUtil.addNature(this.desProject.getProject());				
			
		}
		
		return null;

	}

}
