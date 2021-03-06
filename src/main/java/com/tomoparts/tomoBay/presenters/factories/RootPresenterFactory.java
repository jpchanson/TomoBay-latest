package com.tomoparts.tomoBay.presenters.factories;
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
import com.tomoparts.tomoBay.presenters.AbstractPresenter;
import com.tomoparts.tomoBay.presenters.root.RootPresenter;
/**
 * This class is creates an RootPresenter object
 * @see {@link tomoBay.presenters.root.RootPresenter}
 * @author Jan P.C. Hanson
 *
 */
public final class RootPresenterFactory implements AbstractPresenterFactory
{
	/**
	 * default constructor
	 */
	public RootPresenterFactory()
	{super();}
	/* (non-Javadoc)
	 * @see openDMS.presenters.factories.AbstractEbayPresenterFactory#make()
	 */
	@Override
	public AbstractPresenter make()
	{return new RootPresenter();}
}
