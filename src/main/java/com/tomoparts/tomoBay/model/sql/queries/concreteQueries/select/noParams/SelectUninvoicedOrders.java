package com.tomoparts.tomoBay.model.sql.queries.concreteQueries.select.noParams;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import com.tomoparts.tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;
import com.tomoparts.tomoBay.model.sql.schema.ordersTable.OrdersTable;
/**
 * This class represents a query that selects all data from the orders table that is not
 * currently invoiced as determined by the value of the 'invoiced' field where a value of 0 
 * indicates that the order is not invoicable, a value of 1 indicates that the order is partially
 * invoicable and a value of 2 indicates that the order has been invoiced.
 * @author Jan P.C. Hanson
 *
 */
public  final class SelectUninvoicedOrders extends AbstractSelectNoParamsQuery
{
	/**SQL query string**/
	private static final String query = "SELECT * FROM ebay_orders WHERE invoiced = 0 ORDER BY createdTime ASC;";
	
	/**
	 * default constructor
	 */
	public SelectUninvoicedOrders()
	{super();}
	
	/**
	 * formats the ResultSet (returned from the executed query) as a string
	 * @param results the ResultSet (post query execution)
	 * @return String containing the formatted results.
	 * @throws SQLException
	 */
	@Override
	protected List<HeteroFieldContainer> format(ResultSet results) throws SQLException
	{
		List<HeteroFieldContainer> rows = new ArrayList<HeteroFieldContainer>();
		while (results.next())
		{
			HeteroFieldContainer cols = new HeteroFieldContainer();
			cols.add(OrdersTable.ORDER_ID,results.getString("orderID"));
			cols.add(OrdersTable.BUYERID,results.getString("buyerID"));
			cols.add(OrdersTable.SALES_REC_NO,results.getInt("salesRecNo"));
			cols.add(OrdersTable.SHIPPING_TYPE,results.getString("shippingType"));
			cols.add(OrdersTable.CREATED_TIME,results.getTimestamp("createdTime"));
			cols.add(OrdersTable.INVOICED,results.getInt("invoiced"));
			cols.add(OrdersTable.ORDER_TOTAL,results.getFloat("orderTotal"));
			cols.add(OrdersTable.ACCOUNT,results.getInt("account"));
			rows.add(cols);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryTypes.AbstractDBQuery#queryString()
	 */
	@Override
	protected String queryString()
	{return SelectUninvoicedOrders.query;}
}