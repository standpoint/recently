package task.generated;

import java.util.*;

public class TypeDeposite {

    protected List<TypeDepositor> depositorList;

    public List<TypeDepositor> getDepositorList() {
        if (depositorList == null) {
            depositorList = new ArrayList<TypeDepositor>();
        }
        return this.depositorList;
    }
    
    public void setDepositorList(List<TypeDepositor> depositorList){
        this.depositorList = depositorList;
    }
}
