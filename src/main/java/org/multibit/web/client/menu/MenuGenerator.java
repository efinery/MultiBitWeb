package org.multibit.web.client.menu;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *  <p>Generator to provide the following to clients:<br>
 *  <ul>
 *  <li>Creation of menu items</li>
 *  </ul>
 *  </p>
 *  
 */
public class MenuGenerator extends Generator {

  @Override
  public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {

    try {
      final TypeOracle typeOracle = context.getTypeOracle();
      final JClassType originalType = typeOracle.getType(typeName);
      final String packageName = originalType.getPackage().getName();
      final String originalClassName = originalType.getSimpleSourceName();
      final String generatedClassName = originalClassName + "Gen";

      final ClassSourceFileComposerFactory classFactory = new ClassSourceFileComposerFactory(packageName, generatedClassName);

      // Generated code must have declared imports (will rely on History)
      classFactory.addImport("com.google.gwt.user.client.ui.MenuBar");
      classFactory.addImport("org.multibit.web.client.HistoryCommand");
      classFactory.addImplementedInterface(originalType.getName());

      // Read the multibit.menu file to get the menu structure
      final PrintWriter printWriter = context.tryCreate(logger, packageName, generatedClassName);
      final SourceWriter sourceWriter = classFactory.createSourceWriter(context, printWriter);

      final InputStream menuInputStream = MenuGenerator.class.getResourceAsStream("/multibit.menu");
      final Scanner scanner = new Scanner(menuInputStream);

      // Define the line tokens in the menu descriptor file
      String first, second, third;
      int level = 0;

      sourceWriter.println("public MenuBar createMenu() {");
      sourceWriter.println("MenuBar stack[]= new MenuBar[20];");
      sourceWriter.println("stack[0]=new MenuBar();");

      // Read over the menu descriptor stream
      while (scanner.hasNext()) {
        first = scanner.next();
        if ("menu".equals(first)) {
          // Build a new MenuBar
          second = scanner.nextLine();
          level++;
          sourceWriter.println("stack[%d]=new MenuBar(true);", level);
          sourceWriter.println("stack[%d].addItem(\"%s\",stack[%d]);", (level - 1), second, level);
        } else if ("command".equals(first)) {
          second = scanner.next();
          third = scanner.nextLine().trim();
          sourceWriter.println("stack[%d].addItem(\"%s\", new HistoryCommand(\"%s\"));", level, third, second);
        } else {
          // Assume end of menu
          level--;
        }
      }
      scanner.close();
      sourceWriter.println("return stack[0];");
      sourceWriter.println("}");

      // Commit the generated code
      sourceWriter.commit(logger);

      final String generatedClassQualifiedName = originalType.getParameterizedQualifiedSourceName() + "Gen";
      return generatedClassQualifiedName;

    } catch (final Exception e) {
      throw new UnableToCompleteException();
    }

  }
}
