/*
* JavaBeanStack FrameWork
*
* Copyright (C) 2017 Jorge Enciso
* Email: jorge.enciso.r@gmail.com
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301  USA
*/
package ${package}.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;

import org.apache.log4j.Logger;
import org.javabeanstack.data.IGenericDAO;
import org.javabeanstack.security.IUserSession;
import org.javabeanstack.util.Dates;
import org.javabeanstack.util.Fn;

import static org.javabeanstack.util.Strings.*;

import org.javabeanstack.data.DataNativeQuery;
import org.javabeanstack.data.IDataNativeQuery;
import org.javabeanstack.data.IDataQueryModel;
import org.javabeanstack.error.ErrorManager;

/**
 *
 * @author Jorge Enciso
 */
public class AppUtilSrv implements IAppUtilSrv {
    protected static final Logger LOGGER = Logger.getLogger(AppUtilSrv.class);

    @EJB
    private IGenericDAO dao;

}
