package com.tomoparts.tomoBay.presenters.sales;
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
import java.util.List;

import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import com.tomoparts.tomoBay.model.sql.framework.SelectQueryInvoker;
import com.tomoparts.tomoBay.presenters.AbstractPresenter;
import com.tomoparts.tomoBay.view.AbstractView;
import com.tomoparts.tomoBay.view.ViewFactory;
/**
 * This class represents the History presenter of the Sales area of the WebApp.
 * @author Jan P.C. Hanson
 *
 */
public final class SalesHistoryPresenter implements AbstractPresenter
{
	/**
	 * default ctor
	 */
	public SalesHistoryPresenter()
	{super();}

	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present()
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		String output = "";
		List<HeteroFieldContainer> rows = SelectQueryInvoker.execute
				(SelectQueryInvoker.SelectQueryTypeNoParams.SELECT_INVOICED_ORDERS);
		
		output += view.format(rows);
		
		return output;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
