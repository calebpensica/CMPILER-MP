import gen.APascaletParser;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Double> {
    @Override
    public Double visitAdd(APascaletParser.AddContext ctx) {
        return visit(ctx.NUM(0) + ctx.NUM(1));
    }
}
