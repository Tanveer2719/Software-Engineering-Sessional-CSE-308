package Question1;

public class ImposterAdapter implements CrewMateInterface{
    private ImposterInterface imposter;

    public ImposterAdapter(Imposter imposter){
        this.imposter = imposter;
    }

    @Override
    public void study() {
        imposter.kill();
    }

    @Override
    public void job() {
        imposter.damage();
    }
}
