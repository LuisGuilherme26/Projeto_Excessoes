
class Grafite{
    float calibre;
    String dureza;
    int tamanho;

    public Grafite(float calibre, String dureza, int tamanho) {
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho;
    }
    
    public int desgastePorFolha(){
        if(dureza.equals("HB")){
            return 1;
        }else if (dureza.equals("2B")){
            return 2;
        }else if (dureza.equals("3B")){
            return 3;
        }else{
            return 4;
        }
    }
    
    public String toString(){
        return "Calibre: "+calibre+", Dureza: "+dureza+", Tamanho: "+tamanho;
    }
}

public class Lapiseira {
    
    float calibre;
    Grafite grafite;

    public Lapiseira(float calibre, Grafite grafite) {
        this.calibre = calibre;
        this.grafite = grafite;
    }
    
    public boolean inserir(Grafite grafite){
        if(this.grafite == null){
            if(this.calibre == grafite.calibre){
                this.grafite = grafite;
                return true;
            }else{
                throw new ArithmeticException("Calibre incompativel");
            }
        }else{
            System.out.println("Ja existe grafite");
            return false;
        }
    }
    
    Grafite remover(){
        if(this.grafite != null){
            System.out.println("Grafite retirado");
            grafite = null;
            return grafite;
        }else{
            throw new NullPointerException("Não tem grafite" + grafite);
        }
    }
    
    void escrever(int folhas){
        int desgaste = grafite.desgastePorFolha();
        if(grafite != null){
            for (int i = folhas; i >= 0; i--) {
                if(grafite.tamanho > 0){
                    grafite.tamanho -= desgaste;
                }else{
                    System.out.println("Acabou o seu grafite");
                    if(i > 0){
                        int quant = folhas - i;
                        System.out.println("Numero de folhas completas: "+quant);
                    }
                    grafite = null;
                }
            }
        }
    }

    public String toString(){
        return "Calibre: "+calibre+", Grafite: "+grafite;
    }
    
    public static void main(String[] args) {
        Lapiseira lapi = new Lapiseira((float)0.5, null);
        System.out.println(lapi);
        try{
            lapi.inserir(new Grafite((float)0.7, "2B", 50));
            lapi.inserir(new Grafite((float)0.5, "2B", 50));
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println(lapi);
        
        
        try{
            lapi = new Lapiseira((float)0.3, null);
            lapi.inserir(new Grafite((float)0.3, "2B", 50));
            System.out.println(lapi);
            lapi.inserir(new Grafite((float)0.3, "4B", 70));
            System.out.println(lapi);
            lapi.remover();
            lapi.inserir(new Grafite((float)0.3, "4B", 70));
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println(lapi);
        
        //case escrevendo 1
        try{
            lapi = new Lapiseira((float)0.9, null);
            lapi.inserir(new Grafite((float)0.9, "4B", 4));
            lapi.escrever(1);
            System.out.println(lapi);
            lapi.inserir(new Grafite((float)0.9, "4B", 30));
            lapi.escrever(6);
            System.out.println(lapi);
            lapi.escrever(3);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println(lapi);
    }
}
