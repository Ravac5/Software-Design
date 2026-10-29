public class ejercicio1main{
    void main(){
     ConfFile.initialize("home/user/config/user.conf");
     System.out.println(ConfFile.getConf());
     ConfFile.initialize("E:/config/user.conf"); //comment if getting throw error
     System.out.println(ConfFile.getConf()); //comment if getting throw error
     ConfFile.setConf("~/config/newuser.conf");
     System.out.println(ConfFile.getConf());
    }
}
