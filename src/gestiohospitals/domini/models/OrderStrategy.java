
package gestiohospitals.domini.models;

import java.util.List;


public interface OrderStrategy {
  
    public abstract  void ordenar( List<String[]> metges );
}
