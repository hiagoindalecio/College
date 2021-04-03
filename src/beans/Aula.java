package beans;

public class Aula {
    private int COD_AULA;
    private String NOME_AULA;
    private String DESC_AULA;
    private int COD_PROF;

    public int getCOD_AULA() {
        return COD_AULA;
    }

    public void setCOD_AULA(int COD_AULA) {
        this.COD_AULA = COD_AULA;
    }
    
    public int getCOD_PROF() {
        return COD_PROF;
    }

    public void setCOD_PROF(int COD_PROF) {
        this.COD_PROF = COD_PROF;
    }

    public String getNOME_AULA() {
        return NOME_AULA;
    }

    public void setNOME_AULA(String NOME_AULA) {
        this.NOME_AULA = NOME_AULA;
    }
    
    public String getDESC_AULA() {
        return DESC_AULA;
    }

    public void setDESC_AULA(String DESC_AULA) {
        this.DESC_AULA = DESC_AULA;
    }
    
}
