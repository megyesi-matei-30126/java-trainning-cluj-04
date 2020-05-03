public abstract class TemplateAlg {
    public final void run() {
        step1();
        step2();
        step3();
    }

    abstract void step1();

    abstract void step2();

    abstract void step3();
}
