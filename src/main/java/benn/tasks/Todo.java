package benn.tasks;

public class Todo extends Task {
   public Todo(String description, boolean isDone) {
      super(description);
      this.isDone = isDone;
   }

   @Override
   public String toString() {
      return String.format("[T]%s", super.toString());
   }

   @Override
   public String toStorageFormat() {
      return String.format("T | %d | %s", this.getIsDone() ? 1 : 0, this.getDescription());
   }
}
