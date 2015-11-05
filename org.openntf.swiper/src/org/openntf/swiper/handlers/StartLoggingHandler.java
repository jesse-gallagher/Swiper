package org.openntf.swiper.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.openntf.swiper.util.SwiperUtil;

public class StartLoggingHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
	
		SwiperUtil.startLoggingToFile();		
		return null;
		
	}

	@Override
	public boolean isEnabled() {
		return !SwiperUtil.isLoggingToFile();
	}

	@Override
	public void setEnabled(Object evaluationContext) {

	}

	
	
}
