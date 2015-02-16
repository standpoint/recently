package jdbc_mas;

//здесь хранится имя массива, ко-во строк и ко-во столбцов.
class MasSize {
    
    private int columns;
    private int rows;
    private String name;
    
    public void setName(String n) {
        name=new String(n);
    }
    public void setColumns(int n){
        columns=n;
    }
    public void setRows(int n){
        rows=n;
    }
    public String getName(){
        return name;
    }
    public int getColumns(){
        return columns;
    }
    public int getRows(){
        return rows;
    }

    public boolean equals(Object o) {
        MasSize o1=(MasSize) o;
        if(name.equals(o1.name)) return true;
        else  return false;
    }  
}

