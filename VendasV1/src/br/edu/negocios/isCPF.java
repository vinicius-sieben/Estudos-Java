package br.edu.negocios;

public class isCPF {
    
    public static boolean validar(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos
        
        if (cpf.length() != 11) {
            return false;
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (10 - i);
        }
        
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : (11 - resto);
        
        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (11 - i);
        }
        
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : (11 - resto);
        
        return (digito1 == Character.getNumericValue(cpf.charAt(9))) && 
               (digito2 == Character.getNumericValue(cpf.charAt(10)));
    }
    
    public static void main(String[] args) {
        String cpf = "123.456.789-09";
        boolean resultado = validar(cpf);
        System.out.println(resultado);
    }
}
