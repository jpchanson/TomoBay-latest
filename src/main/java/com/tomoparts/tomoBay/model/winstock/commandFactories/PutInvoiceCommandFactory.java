package com.tomoparts.tomoBay.model.winstock.commandFactories;
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
import java.io.IOException;
import java.net.UnknownHostException;

import com.tomoparts.tomoBay.model.winstock.commands.AbstractWinstockCommand;
import com.tomoparts.tomoBay.model.winstock.commands.PutInvoiceCommand;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class PutInvoiceCommandFactory implements AbstractWinstockCommandFactory
{
	/**
	 * default ctor
	 */
	public PutInvoiceCommandFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.winstock.commandFactories.AbstractWinstockCommandFactory#make()
	 */
	@Override
	public AbstractWinstockCommand make() throws UnknownHostException, IOException
	{return new PutInvoiceCommand();}

}
