import com.easymap.management.api.OrganizationManager;
import com.easymap.management.api.UserManager;
import com.easymap.management.unit.Organization;
import com.easymap.management.user.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */
public class Test {

    public static  void main(String [] arg) throws Exception {
        String url = "http://10.60.148.55:8080/EzManager6";
        OrganizationManager omgt = new OrganizationManager(url);
        UserManager umgt = new UserManager(url);
        User user = umgt.getUserById("anonymous");
        Organization org = omgt.findOrganizationById(user.getOrgId());
        Organization parent = omgt.findOrganizationById(org.getSsjgdm());
        List<Organization> list1 = omgt.findOrganizationsByLevel(1);
        List<Organization> children = omgt.findChildrenOrganizations(parent.getId());
    }
}
