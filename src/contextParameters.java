import gen.APascaletParser;

public class contextParameters {
    public contextParameters()
    {

    }
    public contextParameters(String[] parameters, APascaletParser.BlockContext currentContext) {
        this.parameters = parameters;
        this.currentContext = currentContext;
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

}
