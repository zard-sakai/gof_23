package gill_design.transfer_design;

public class BusinessException extends RuntimeException{

    private String code;
    private String msg;

    public BusinessException(String code, String msg){

    }
}
