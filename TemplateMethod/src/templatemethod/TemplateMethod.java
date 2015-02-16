package templatemethod;

abstract class Build {
    public void buildBuilding(){
        buildFoundation();
        buildWalls();
        buildRoof();
    }
    
    protected abstract void buildFoundation();
    protected abstract void buildWalls();
    protected abstract void buildRoof();
}

class BuildCowshade extends Build {
    protected void buildFoundation(){}
    protected void buildWalls(){}
    protected void buildRoof(){}
}
class BuildSkyscrapper extends Build {
    protected void buildFoundation(){}
    protected void buildWalls(){}
    protected void buildRoof(){}
}
public class TemplateMethod {

    public static void main(String[] args) {
        Build b = new BuildCowshade();
        b.buildBuilding();
    }
    
}
