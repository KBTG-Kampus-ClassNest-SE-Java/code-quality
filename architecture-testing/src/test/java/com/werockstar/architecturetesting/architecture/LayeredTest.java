package com.werockstar.architecturetesting.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.werockstar.architecturetesting", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredTest {

    @ArchTest
    static final ArchRule controller_packages = classes().that().areAnnotatedWith(RestController.class).should().resideInAPackage("..controller..");

    @ArchTest
    static final ArchRule service_packages = classes().that().areAnnotatedWith(Service.class).should().resideInAPackage("..service..");

    @ArchTest
    static final ArchRule repository_packages = classes().that().areAnnotatedWith(Repository.class).should().resideInAPackage("..repository..");

}
