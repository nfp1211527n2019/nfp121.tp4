package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;

    public PileModele(PileI<T> pile) {
        
        this.pile = pile;
    }

    public void empiler(T o) throws PilePleineException {
        
       if(estPleine()){
           throw new PilePleineException();
        }
      pile.empiler(o);
      
      setChanged();
      
      notifyObservers(o);
    }

    public T depiler() throws PileVideException {
        
         if(estVide()){
           throw new PileVideException();
        }
        
        T removed = pile.depiler();
        
        setChanged();
        
        notifyObservers();
       
        return removed ;
    }

    public T sommet() throws PileVideException {
        
         if(estVide()){
           throw new PileVideException();
        }
        
         return pile.sommet() ;
    }

    public int taille() {
        
        return pile.taille();
    }

    public int capacite() {
        
        return pile.capacite();
    }

    public boolean estVide() {
        
        return pile.estVide();
    }

    public boolean estPleine() {
        
        return pile.estPleine();
    }

    public String toString() {
        
        return pile.toString();
    }
}

