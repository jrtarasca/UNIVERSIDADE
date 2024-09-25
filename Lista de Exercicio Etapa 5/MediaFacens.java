import java.util.Scanner;

class Avaliacoes {
    private double AC1;
    private double AC2;
    private double AG;
    private double AF;

    // Construtor da classe Avaliacoes
    public Avaliacoes(double AC1, double AC2, double AG, double AF) {
        this.AC1 = AC1;
        this.AC2 = AC2;
        this.AG = AG;
        this.AF = AF;
    }

    //Calcular a média
    public double calcularMedia() {
        return (AC1 * 0.15) + (AC2 * 0.30) + (AG * 0.10) + (AF * 0.45);
    }

    //Verificar quais notas estão abaixo da nota mínima
    public void verificarNotasAbaixoMinima(double minima) {
        if (AC1 < minima) {
            System.out.println("AC1 está abaixo: " + AC1);
        }
        if (AC2 < minima) {
            System.out.println("AC2 está abaixo: " + AC2);
        }
        if (AG < minima) {
            System.out.println("AG está abaixo: " + AG);
        }
        if (AF < minima) {
            System.out.println("AF está abaixo: " + AF);
        }
    }
}

class Aluno {
    private String nome;
    private Avaliacoes avaliacoes;
    private double frequencia; 

    // Construtor da classe Aluno
    public Aluno(String nome, Avaliacoes avaliacoes, double frequencia) {
        this.nome = nome;
        this.avaliacoes = avaliacoes;
        this.frequencia = frequencia;
    }

    //Avaliar o aluno
    public void avaliar(double minima) {
        if (frequencia < 75) {
            System.out.println("Reprovado por falta. Frequência: " + frequencia + "%");
            return;
        }
        
        double media = avaliacoes.calcularMedia();
        System.out.println("Média final do aluno " + nome + ": " + media);
        
        avaliacoes.verificarNotasAbaixoMinima(minima);
        
        if (media >= minima) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
    }
}

public class MediaFacens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Calculadora de Média");
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite sua AC1:");
        double AC1 = scanner.nextDouble();

        System.out.println("Digite sua AC2:");
        double AC2 = scanner.nextDouble();

        System.out.println("Digite sua AG:");
        double AG = scanner.nextDouble();

        System.out.println("Digite sua AF:");
        double AF = scanner.nextDouble();

        System.out.println("Qual a frequência do aluno em percentual?");
        double frequencia = scanner.nextDouble();

        System.out.println("Qual a nota mínima para aprovação?");
        double minima = scanner.nextDouble();

        // Criar uma instância de Avaliacoes e Aluno
        Avaliacoes avaliacoes = new Avaliacoes(AC1, AC2, AG, AF);
        Aluno aluno = new Aluno(nome, avaliacoes, frequencia);

        aluno.avaliar(minima);

        scanner.close();
    }
}
