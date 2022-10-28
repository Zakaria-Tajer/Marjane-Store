package Marj.helper;

public class UUIDs {

    public String uuid() {
        return java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }


}
