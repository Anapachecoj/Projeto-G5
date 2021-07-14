package aplicacao;

import java.util.Scanner;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaEmpresa;
import entidades.ContaEspecial;
import entidades.ContaEstudantil;
import entidades.ContaPoupanca;
import entidades.MenuPrincipal;

public class JEDBANK {

	static int opcao;
	static String nome;
	static int numeroConta;
	static MenuPrincipal menu = new MenuPrincipal();
	static Scanner leia = new Scanner(System.in);	
	
	public static void menu(){	
		menu.getCabecalho();
			
		// SOLICITANDO INFORMA��ES DO USUARIO
		System.out.print("NOME CLIENTE: ");
		nome = leia.next().toUpperCase();
		System.out.print("NUMERO DA CONTA: ");
		numeroConta = leia.nextInt();
		
		//APRESENTANDO AS OP��ES DE CONTAS PARA O USUARIO
		System.out.println("\n1 - CONTA POUPAN�A\n2 - CONTA CORRENTE\n3 - CONTA ESPECIAL\n4 - CONTA EMPRESA\n5 - CONTA ESTUDANTIL\n6 - SAIR\n");
    	System.out.print("CONTA QUE DESEJA ACESSAR: ");
		opcao = leia.nextInt();
		
		while(opcao < 1 || opcao > 6) {
			System.out.print("DIGITE UMA CONTA VALIDA: ");
			opcao = leia.nextInt();
		}
	}
	
	public static void main(String[] args) {
		
		//FUN��O MENU
		menu();
		
		//LA�OS CONDICIONAIS RESPONSAVEL POR DIRECIONAR O USUARIO PARA A CLASSE E METODOS DE ACORDO COM A CONTA ESCOLHIDA
		if(opcao == 1) {			
			
			ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, nome);
					
			for(int i=1; i<=10; i++) {	
				menu.getCabecalho();
				System.out.println("\n                      CONTA POUPAN�A\n");
				System.out.println("NOME CLIENTE: " + contaPoupanca.getNomeCliente());
				System.out.println("NUMERO CONTA: " + contaPoupanca.getNumero());
				System.out.println("SALDO ATUAL: R$ " + contaPoupanca.getSaldo());
				System.out.println();
				System.out.println(i + "� MOVIMENTO");
				
				contaPoupanca.movimentacao();
				if(contaPoupanca.getSair() == 'S') {
					menu();		
		        }
				menu.repeteOperacao();
				if(menu.isRepete() == false){
					System.out.println();
					System.out.print("INFORME O DIA: ");
					int dia = leia.nextInt();
					contaPoupanca.correcaoDeSaldo(dia);
					menu();
			    }
			}
			System.out.println("VOC� REALIZOU O MAXIMO DE MOVIMENTA��ES DI�RIAS. VOLTE AMANH�!");
			menu();
		}	
		else if(opcao == 2) {
			ContaCorrente contaCorrente = new ContaCorrente(numeroConta, nome);
			
			for(int i=1; i<=10; i++) {
				menu.getCabecalho();
				System.out.println("\n                      CONTA CORRENTE\n");
				System.out.println("NOME CLIENTE: " + contaCorrente.getNomeCliente());
				System.out.println("NUMERO CONTA: " + contaCorrente.getNumero());
				System.out.println("SALDO ATUAL: R$ " + contaCorrente.getSaldo());
				System.out.println();
				System.out.println(i + "� MOVIMENTO");
				
				contaCorrente.movimentacao();
				if(contaCorrente.getSair() == 'S') {
					menu();										
		        }
				menu.repeteOperacao();
				if(menu.isRepete() == false){
					contaCorrente.solicitaCheque();
					menu();
			    }
			}
			System.out.println("VOC� REALIZOU O MAXIMO DE MOVIMENTA��ES DI�RIAS. VOLTE AMANH�!");
			menu();
		}
		else if(opcao == 3) {
			ContaEspecial contaEspecial = new ContaEspecial(numeroConta, nome);
			
			for(int i=1; i<=10; i++) {
				menu.getCabecalho();
				System.out.println("\n                      CONTA ESPECIAL\n");
				System.out.println("NOME CLIENTE: " + contaEspecial.getNomeCliente());
				System.out.println("NUMERO CONTA: " + contaEspecial.getNumero());
				System.out.println("LIMITE DISPONIVEL NO VALOR DE: R$ " + contaEspecial.getLimite());
				System.out.println("SALDO ATUAL: R$ " + contaEspecial.getSaldo());
				System.out.println();
				System.out.println(i + "� MOVIMENTO");
				
				contaEspecial.movimentacao();
				if(contaEspecial.getSair() == 'S') {
					menu();							
				}
				menu.repeteOperacao();
				if(menu.isRepete() == false){
					menu();
				}		
		        	
		   }
		    System.out.println("VOC� REALIZOU O MAXIMO DE MOVIMENTA��ES DI�RIAS. VOLTE AMANH�!");
			menu();
    }
		else if(opcao == 4) {
			  ContaEmpresa contaEmpresa = new ContaEmpresa(numeroConta, nome);
				
				for(int i=1; i<=10; i++) {
					menu.getCabecalho();
					System.out.println("\n                      CONTA EMPRESA\n");
					System.out.println("NOME CLIENTE: " + contaEmpresa.getNomeCliente());
					System.out.println("NUMERO CONTA: " + contaEmpresa.getNumero());
					System.out.println("EMPRESTIMO DISPONIVEL NO VALOR DE: R$ " + contaEmpresa.getEmprestimoEmpresa());
					System.out.println("SALDO ATUAL: R$ " + contaEmpresa.getSaldo());
					System.out.println();
					System.out.println(i + "� MOVIMENTO");
					contaEmpresa.movimentacao();
					if(contaEmpresa.getSair() == 'S') {
						menu();	
			        }	
					menu.repeteOperacao();
					if(menu.isRepete() == false){
						menu();
				    }
			    }	
				System.out.println("VOC� REALIZOU O MAXIMO DE MOVIMENTA��ES DI�RIAS. VOLTE AMANH�!");
				menu();
		}
		else if(opcao == 5) {
			ContaEstudantil contaEstudantil = new ContaEstudantil(numeroConta, nome);
			
			for(int i=1; i<=10; i++) {
				menu.getCabecalho();
				System.out.println("\n                      CONTA ESTUDANTIL\n");
				System.out.println("NOME CLIENTE: " + contaEstudantil.getNomeCliente());
				System.out.println("NUMERO CONTA: " + contaEstudantil.getNumero());
				System.out.println("EMPRESTIMO DISPONIVEL NO VALOR DE: R$ " + contaEstudantil.getLimiteEstudantil());
				System.out.println("SALDO ATUAL: R$ " + contaEstudantil.getSaldo());
				System.out.println();
				System.out.println(i + "� MOVIMENTO");
				contaEstudantil.movimentacao();
				if(contaEstudantil.getSair() == 'S') {
					menu();		
		        }	
				menu.repeteOperacao();
				if(menu.isRepete() == false){
					menu();
			    }
		    }
			System.out.println("VOC� REALIZOU O MAXIMO DE MOVIMENTA��ES DI�RIAS. VOLTE AMANH�!");
			menu();
		}
		else if(opcao == 6) {
			System.out.println("\n                       FINALIZADO OPERA��O");
			System.out.println("\n                         VOLTE SEMPRE! :)");
		}	
	}
}