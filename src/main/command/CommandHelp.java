package main.command;

public class CommandHelp extends Command {
    @Override
    public String name() {
        return "help";
    }

    @Override
    public void execute(String[] args, String rawInput) {
        if (args.length > 1 && args[1].equals("--help")) {
            System.out.println(help());
            return;
        }
        System.out.println("""
                LISTA DE COMANDOS:
                pwd                      → Exibe o diretório atual.
                ls                       → Lista os arquivos e diretórios do diretório atual.
                cd <diretório>           → Navega entre diretórios.
                mkdir <nome>             → Cria um novo diretório.
                touch <arquivo>          → Cria um novo arquivo vazio.
                rm <arquivo/diretório>   → Remove um arquivo ou diretório.
                cat <arquivo>            → Exibe o conteúdo de um arquivo.
                echo <texto> > <arquivo> → Escreve texto em um arquivo.
                history                  → Mostra o histórico de comandos digitados.
                exit                     → Encerra o programa.
                """);
    }
    public String help() {
        return """
Comando: help
Descrição: Mostra a lista de comandos no sistema.
Uso:
    help
""";
    }
}
