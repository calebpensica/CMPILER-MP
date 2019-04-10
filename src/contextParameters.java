import gen.APascaletParser;

public class contextParameters {
    public contextParameters()
    {

    }
    public contextParameters(String[] parameters, APascaletParser.BlockContext currentContext) {
        this.parameters = parameters;
        this.currentContext = currentContext;
        this.functionContext = null;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public APascaletParser.BlockContext getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(APascaletParser.BlockContext currentContext) {
        this.currentContext = currentContext;
    }

    private String parameters [];
    private APascaletParser.BlockContext currentContext;

    public APascaletParser.FunctionDeclarationContext getFunctionContext() {
        return functionContext;
    }

    public void setFunctionContext(APascaletParser.FunctionDeclarationContext functionContext) {
        this.functionContext = functionContext;
    }

    private APascaletParser.FunctionDeclarationContext functionContext;

}
