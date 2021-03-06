package com.tomoparts.tomoBay;

import org.apache.log4j.Logger;

import com.tomoparts.tomoBay.model.dataTypes.ServerStatus;
import com.tomoparts.tomoBay.model.services.ServiceFactory;
import com.tomoparts.tomoBay.model.services.ServiceFactory.ConfiguredServiceType;
import com.tomoparts.tomoBay.model.services.ServiceScheduler;
import com.tomoparts.tomoBay.model.services.emailErrorsService.EmailErrorsConfig;
import com.tomoparts.tomoBay.view.HttpServer;
/**
 * The entry point into the program, this is a stopgap solution to get invoices ,of orders that
 * are completely fulfillable, printed automatically
 * 
 * @author Jan P.C. Hanson
 *
 */
public final class MAIN
{
	static final private Logger log = Logger.getLogger(MAIN.class);
	
	public static final void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		log.warn("*******************************PROGRAM START*******************************");
		final HttpServer server = new HttpServer();
		server.start(1337);
		
		
		ServerStatus.instance().setStatus(ServerStatus.RunLevel.RUNNING);
		final ServiceScheduler services = new ServiceScheduler(5);
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.OUT_OF_HOURS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.RESCAN_ERRORS_SERVICE));
		services.add(ServiceFactory.make(ServiceFactory.ServiceType.CHECK_ERRORS));
		final String data = "<EMAIL>"
				+ "<TO>tomomotorbay@gmail.com</TO>"
//				+ "<TO>paul@tomoparts.co.uk</TO>"
				+ "<TO>steve@tomoparts.co.uk</TO>"
				+ "<SUBJECT>ERRORS TO FIX!!!!!</SUBJECT>"
				+ "</EMAIL>";
		services.add(ServiceFactory.make(
										ConfiguredServiceType.EMAIL_ERRORS_SERVICE,
										new EmailErrorsConfig().configure(data)
										));
		services.start(20);
	}
}
