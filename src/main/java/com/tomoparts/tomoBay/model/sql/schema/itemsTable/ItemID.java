package com.tomoparts.tomoBay.model.sql.schema.itemsTable;
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
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import com.tomoparts.tomoBay.model.dataTypes.heteroTypeContainer.TypeDef;
/**
 * this is the itemID field of the ebay_items table, this is the primary key for the ebay_items table
 * and the value is retrieved using the eBay API. 
 * 
 * This field in combination with the TransactionID of the ebay_transactions table make up the OrderID
 * in orders that contain only one transaction.
 * - Type: BIGINT
 * - Size: 13
 * @author Jan P.C. Hanson
 *
 */
public final class ItemID implements AbstractField
{
	/**the size of this field**/
	private static final int size_M = 13;

	/**
	 * dfefault ctor
	 */
	public ItemID()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#type()
	 */
	@Override
	public String type()
	{return TypeDef.LONG;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.dbSchema.AbstractDBField#size()
	 */
	@Override
	public int size()
	{return ItemID.size_M;}
}
