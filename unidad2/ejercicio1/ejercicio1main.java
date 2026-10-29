public class ejercicio1main{
    void main(){
     ConfFile.initialize("home/user/config/user.conf");
     System.out.println(ConfFile.getConf());
     //ConfFile.initialize("E:/config/user.conf");
     //System.out.println(ConfFile.getConf());
     ConfFile.setConf("~/config/newuser.conf");
     System.out.println(ConfFile.getConf());
    }
}
