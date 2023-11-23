package base.no.states;

public abstract class Area {
    // Areas are the non-specified version of Partitions and Spaces,
    // i.e. their shared values
    protected final String id;
    protected static Partition rootArea;

    public Area(final String idLocal, final Partition rootLocal) {
        this.id = idLocal;
        rootArea = rootLocal;
        if (this.rootArea != null) { //If this area has a father...
            this.rootArea.addChild(this);
            //we notify the father of this area that it has a new children
        }
    }
    public String getId() {
        return id;
    }
    public abstract void acceptVisitor(Visitor visitor);
    // Check Partitions or Space for specific implementation
}
