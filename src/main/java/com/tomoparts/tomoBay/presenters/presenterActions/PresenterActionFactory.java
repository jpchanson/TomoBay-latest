package com.tomoparts.tomoBay.presenters.presenterActions;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import gnu.trove.map.hash.THashMap;

import java.util.Map;

import com.tomoparts.tomoBay.presenters.presenterActions.factories.AbstractPresenterActionFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.BuyerDetailsFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.BuyerListFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.GenerateRoyalMailCSVFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.InvoiceOrdersFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.LogFileViewerFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.MarkAsInvoicedFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.MarkAsUninvoicedFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.OrderInfoFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.PeriodicServicesControllerFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.PrintInvoicesFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.ReScanBuyerFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.ReScanListingFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.factories.StockReOrderAnalysisFactory;

/**
 * This class provides static functionality for creating AbstractPresenterActions
 * @author Jan P.C. Hanson
 *
 */
public final class PresenterActionFactory
{
	public enum PresenterActions
				{
					LOG_FILE_VIEWER,
					
					MARK_AS_INVOICED,
					
					MARK_AS_UNINVOICED,
					
					ORDER_INFO,
					
					PERIODIC_SERVICES_CONTROLLER,
					
					RE_SCAN_LISTING,
					
					BUYER_DETAILS,
					
					BUYER_LIST,
					
					RE_SCAN_BUYER,
					
					INVOICE_ORDERS,
					
					PRINT_INVOICES,
					
					GENERATE_ROYAL_MAIL_CSV,
					
					STOCK_REORDER_ANALYSIS
				}
	
	/**maps the type string to an action**/
	private static final Map<PresenterActions, AbstractPresenterActionFactory> actionMap_M
				= new THashMap<PresenterActions, AbstractPresenterActionFactory>()
				{{
					put(PresenterActions.LOG_FILE_VIEWER, new LogFileViewerFactory());
					put(PresenterActions.MARK_AS_INVOICED, new MarkAsInvoicedFactory());
					put(PresenterActions.MARK_AS_UNINVOICED, new MarkAsUninvoicedFactory());
					put(PresenterActions.ORDER_INFO, new OrderInfoFactory());
					put(PresenterActions.PERIODIC_SERVICES_CONTROLLER, new PeriodicServicesControllerFactory());
					put(PresenterActions.RE_SCAN_LISTING, new ReScanListingFactory());
					put(PresenterActions.BUYER_DETAILS, new BuyerDetailsFactory());
					put(PresenterActions.BUYER_LIST, new BuyerListFactory());
					put(PresenterActions.RE_SCAN_BUYER, new ReScanBuyerFactory());
					put(PresenterActions.INVOICE_ORDERS, new InvoiceOrdersFactory());
					put(PresenterActions.PRINT_INVOICES, new PrintInvoicesFactory());
					put(PresenterActions.GENERATE_ROYAL_MAIL_CSV, new GenerateRoyalMailCSVFactory());
					put(PresenterActions.STOCK_REORDER_ANALYSIS, new StockReOrderAnalysisFactory());
				}};

	/**
	 * default ctor
	 */
	public PresenterActionFactory()
	{super();}

	/**
	 * this method will provide you with the specific AbstractPresenterAction that you request 
	 * using the PresenterAction provided as the argument to this method.
	 * @param action PresenterAction enum const specifying the AbstractPresenterAction to provide.
	 * @return AbstractPresenterAction requested.
	 */
	public static final AbstractPresenterAction make(PresenterActionFactory.PresenterActions action)
	{return PresenterActionFactory.actionMap_M.get(action).make();}
}
