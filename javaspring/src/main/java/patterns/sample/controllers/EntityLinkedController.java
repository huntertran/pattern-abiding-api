package patterns.sample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patterns.sample.utils.EntityLinking.LinkedResource;
import patterns.sample.utils.EntityLinking.ResourceVisitor;
import patterns.sample.utils.EntityLinking.LogicABResourceVisitorImplementation;
import patterns.sample.utils.EntityLinking.LogicCDResourceVisitorImplementation;


// double dispatch

@RestController
@RequestMapping("/entitylinked")
public class EntityLinkedController {
    @GetMapping("/logicABResources")
    public String getWithLogicAB() {
        LinkedResource[] resources = new LinkedResource[] { new SampleRelatedResourceController() };

        ResourceVisitor visitor = new LogicABResourceVisitorImplementation();

        String result = "";

        for (LinkedResource resource : resources) {
            result += resource.accept(visitor);
        }

        return result;
    }

    @GetMapping("/logicCDResources")
    public String getWithLogicCD() {
        LinkedResource[] resources = new LinkedResource[] { new SampleRelatedResourceController() };

        ResourceVisitor visitor = new LogicCDResourceVisitorImplementation();

        String result = "";

        for (LinkedResource resource : resources) {
            result += resource.accept(visitor);
        }

        return result;
    }
}