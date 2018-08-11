package br.edu.fbv.modelos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestandoEscrita {
	public static void main(String[] args) throws IOException {
		
		
	
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("c:/EscritaUrna.txt", true));
		Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar(); 
		bw.newLine();
		bw.write("Voto Computado Dia");
		bw.newLine();
		 SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
		bw.write(formatador.format(calendar.getTime()));
		bw.close();

    }
		
		}
	
	
		
		

	
	
