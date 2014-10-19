/*
Copyright (c) 2012 Marco Amadei.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
USA

You can contact Marco Amadei at amadei.mar@gmail.com.

*/
package net.ucanaccess.commands;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.healthmarketscience.jackcess.Cursor;

public interface ICursorCommand extends ICommand {
	public boolean currentRowMatches(Cursor cur, Map<String, Object> currentRow)
			throws IOException;
	
	public IndexSelector getIndexSelector();
	
	public Map<String, Object> getRowPattern();
	
	public void persistCurrentRow(Cursor cur) throws IOException, SQLException;
}
