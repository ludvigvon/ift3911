package gestion;

public interface Command {

	public abstract void execute();

	public abstract void undo();

}