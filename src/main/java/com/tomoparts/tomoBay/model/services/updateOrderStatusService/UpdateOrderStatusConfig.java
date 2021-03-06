package com.tomoparts.tomoBay.model.services.updateOrderStatusService;
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
import com.tomoparts.tomoBay.model.services.AbstractConfiguration;
/**
 * configuration object for the UpdateOrderStatusService, carries OrderStatus (enum) information
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateOrderStatusConfig implements AbstractConfiguration<OrderStatus>
{

	private OrderStatus status_M;
	
	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractConfiguration#configure(java.lang.Object)
	 */
	@Override
	public AbstractConfiguration<OrderStatus> configure(OrderStatus value)
	{this.status_M = value; return this;}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractConfiguration#configure()
	 */
	@Override
	public OrderStatus configure()
	{return this.status_M;}

}
