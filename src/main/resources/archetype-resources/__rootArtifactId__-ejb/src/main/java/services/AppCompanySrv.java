package ${package}.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.ErrorManager;
import org.javabeanstack.model.IAppCompany;
import org.javabeanstack.security.IUserSession;
import org.javabeanstack.services.DataService;
import org.javabeanstack.services.IAppCompanySrv;
import org.javabeanstack.util.Fn;

/**
 *
 * @author Jorge Enciso
 */
public class AppCompanySrv extends DataService implements IAppCompanySrv {
    private static final Logger LOGGER = Logger.getLogger(AppCompanySrv.class);    

    @Override
    public List<IAppCompany> getAppCompanyLight(IUserSession userSession) {
        String queryString = "select o from AppCompanyLight o "
                + " where not exists("
                + "              select '' "
                + "              from AppCompanyAllowed d "
                + "              where d.idcompany = o.idcompany "
                + "              and d.iduser   = :idusuario"
                + "              and d.deny = true)";
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put("idusuario", userSession.getUser().getIduser());
            List<IAppCompany> query = findListByQuery("", queryString, parameters);
            return query;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
        }
        return null;
    }

    @Override
    public List<IAppCompany> getAppCompany(IUserSession userSession) {
        String queryString = "select o from AppCompany o "
                + " where not exists("
                + "              select '' "
                + "              from AppCompanyAllowed d "
                + "              where d.idcompany = o.idcompany "
                + "              and d.iduser   = :idusuario"
                + "              and d.deny = true)";
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put("idusuario", userSession.getUser().getIduser());
            List<IAppCompany> query = findListByQuery("", queryString, parameters);
            return query;
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
        }
        return null;
    }

    @Override
    public <T extends IDataRow> List<T> getDataRows(String sessionId, Class<T> type, 
            String order, String filter, Map<String, Object> params, 
            int firstRow, int maxRows) throws Exception {
        
        String query = getSelectCmd(sessionId, type, order, filter);
        if (maxRows == -1) {
            maxRows = 999999999;
        }
        List<T> dataRows;
        if (maxRows == 0) {
            dataRows = new ArrayList();
        } else {
            dataRows = (ArrayList<T>) dao.findListByQuery(null, query, params, firstRow, maxRows);                
        }
        return dataRows;
    }


    @Override
    public <T extends IDataRow> String getSelectCmd(String sessionId, Class<T> type, String order, String filter) {
        IUserSession userSession = getUserSession(sessionId);
        String queryString = "select o from AppCompany o "
                + " where not exists("
                + "              select '' "
                + "              from AppCompanyAllowed d "
                + "              where d.idcompany = o.idcompany "
                + "              and d.iduser   = "+userSession.getUser().getIduser()
                + "              and d.deny = true) ";
        
        filter = Fn.nvl(filter, "");
        order = Fn.nvl(order, "");

        //Filtro
        if (!"".equals(filter)) {
            queryString += " and (" + filter + ")";
        }
        //Orden
        if (!"".equals(order)) {
            queryString += " order by " + order;
        }
        return queryString;
    }
}
