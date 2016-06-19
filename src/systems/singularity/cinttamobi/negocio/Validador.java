package systems.singularity.cinttamobi.negocio;

/**
 * Created by phts on 19/06/16.
 */
public class Validador {
    public static String validate(String input, String regex, int length, Exception exception) throws Exception {
        if (input != null) {
            input = input.replaceAll(regex, "");
            if(input.length() != length)
                throw exception;
            return input;
        } else
            throw exception;
    }
}
