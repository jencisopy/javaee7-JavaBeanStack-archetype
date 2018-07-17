/*
* JavaBeanStack FrameWork
*
* Copyright (C) 2018 Jorge Enciso
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
package ${package}.config;

import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.javabeanstack.config.AppGenericConfig;
import org.javabeanstack.error.ErrorManager;
import org.javabeanstack.io.IOUtil;
import org.javabeanstack.xml.DomW3cParser;
import static org.javabeanstack.util.Strings.decode64;

/**
 *
 * @author Jorge Enciso
 */
//@Singleton
@Startup
@Lock(LockType.READ)
public class AppConfig extends AppGenericConfig{
    @PostConstruct
    public void init() {
        InputStream xml = null;
        //Buscar en resource/config archivos de configuración.
        try {
            //System        
            xml = IOUtil.getResourceAsStream(getClass(), "/config/system.xml");
            Document dom = DomW3cParser.loadXml(xml);
            config.put("SYSTEM", dom);
            String edicion = DomW3cParser.getPropertyValue(dom, "edicion", "/Configuration/Sistema");
            edicion = decode64(edicion);
            //Ediciones
            xml = IOUtil.getResourceAsStream(getClass(), "/config/ediciones.xml");
            //Solo el nodo correspondiente a la edición.        
            dom = DomW3cParser.newDocument();
            Element root = (Element)DomW3cParser.
                    selectSingleNode(DomW3cParser.loadXml(xml), edicion);
            dom.appendChild(dom.adoptNode(root.cloneNode(true)));
            config.put("EDICIONES", dom);
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
        } finally {
            IOUtils.closeQuietly(xml);
        }
    }
}


