import java.util.HashMap;
import java.util.HashSet;

public class TablaSimbolos {
	public final static String ERROR_NOEXISTE = "ERROR6: Variable no declarada";
	public final static String ERROR_DECLARADA = "ERROR7: Esta variable ya ha sido declarada";

	public enum Tipo {
		CHAR, INT, FLOAT, STRING, BOOLEAN, ARRAY_CHAR, ARRAY_INT, ARRAY_FLOAT, ARRAY_STRING, ARRAY_CHAR_2D, ARRAY_INT_2D, ARRAY_STRING_2D
	}

	// Hashmap que guarda los identificadores y sus tipos de las variables declaradas.
	public static HashMap<String, Tipo> tablaTipos = new HashMap<String, Tipo>();

	public static void insertar(String ident, Tipo t) {
		if (!estaIdent(ident)) {
			tablaTipos.put(ident, t);
		} else {
			// Errores.varDeclarada(ident);
		}
	}

	public static boolean estaIdent(String ident) {
		return tablaTipos.containsKey(ident);
	}

	public static Tipo tipo(String ident) {
		if (!estaIdent(ident))
			Errores.noVar(ident);
		return tablaTipos.get(ident);
	}

	public static void setTipo(String ident, Tipo t) {
		if (!estaIdent(ident))
			Errores.noVar(ident);
		tablaTipos.replace(ident, t);
	}

	public static void imprimirValores() {
		System.out.println("Tabla de simbolos");
		for (String key : tablaTipos.keySet()) {
			System.out.println(key + " = " + tablaTipos.get(key));
		}
	}

	public static HashMap<String, Pair> matSizes = new HashMap<String, Pair>(); // Estructura que guarda los tamaños de los arrays

	public static void declararDimensions(String ident, int tam1, int tam2) {
		if (estaIdent(ident)) {
			matSizes.put(ident, new Pair(tam1, tam2));
		}
	}

	public static void sustituirKeyDimensionMat(String newIdent, String oldIdent) {
		if (estaIdent(oldIdent)) {
			Pair dimensions = matSizes.get(oldIdent);
			matSizes.remove(oldIdent);
			matSizes.put(newIdent, dimensions);
		}
	}

	public static Pair getDimensionsMat(String ident) {
		if (!estaIdent(ident))
			Errores.noVar(ident);
		return matSizes.get(ident);
	}

	public static void imprimirDimMat() {
		System.out.println("Tabla de Dimensiones");
		for (String key : arraySizes.keySet()) {
			Pair dim = matSizes.get(key);
			System.out.println(key + " = (" + dim.getDim1() + ", " + dim.getDim2() + ")");
		}
	}
	 
	public static boolean esMatriz(String ident) {
		return matSizes.containsKey(ident);
	}

	
	public static HashMap<String, Integer> arraySizes = new HashMap<String, Integer>();//Estructura que guarda los tamaños de los arrays
	
	public static void declararTamanio(String ident, int tam) {
		if (estaIdent(ident)) {
			arraySizes.put(ident, tam);
		} 
	}
	public static void sustituirKeyTamanio(String newIdent, String oldIdent) {
		if (estaIdent(oldIdent)) {
			int tam = arraySizes.get(oldIdent);
			arraySizes.remove(oldIdent);
			arraySizes.put(newIdent, tam);
		} 
	}
	public static int getTamanio(String ident) {
		if (!estaIdent(ident)) Errores.noVar(ident);
		return arraySizes.get(ident);
	}
	public static void imprimirTamanios() {
		System.out.println("Tabla de tamanios");
		for (String key : arraySizes.keySet()) {
			System.out.println(key + " = " + arraySizes.get(key));
		}
	}
	public static boolean esArray(String ident) {
		return arraySizes.containsKey(ident);
	}
	
}

	

