package com.school.things.controllers;

import com.school.things.entities.items.*;
import com.school.things.requests.UniformReceiptRequest;
import com.school.things.requests.UniformItemRequest;
import com.school.things.entities.UniformReceipt;
import com.school.things.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/uniform-receipts")
public class UniformReceiptController {

    @Autowired
    private PantsRepository pantsRepository;

    @Autowired
    private SkirtRepository skirtRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private ShortsRepository shortsRepository;

    @Autowired
    private UniformReceiptRepository uniformReceiptRepository;

    @PostMapping
    public ResponseEntity<UniformReceipt> createReceipt(@RequestBody UniformReceiptRequest request) {
        UniformReceipt receipt = new UniformReceipt();
        List<UniformReceiptItem> items = new ArrayList<>();

        for (UniformItemRequest itemRequest : request.getItems()) {
            UniformReceiptItem item = new UniformReceiptItem();

            switch (itemRequest.getName().toLowerCase()) {
                case "pants":
                    Pants pants = pantsRepository.findById(itemRequest.getUniformId())
                            .orElse(new Pants());
                    pants.setName(itemRequest.getName());
                    pants.setColor(itemRequest.getColor());
                    pants.setSize(itemRequest.getSize());
                    item.setPants(pants);
                    break;
                case "skirt":
                    Skirt skirt = skirtRepository.findById(itemRequest.getUniformId())
                            .orElse(new Skirt());
                    skirt.setName(itemRequest.getName());
                    skirt.setColor(itemRequest.getColor());
                    skirt.setSize(itemRequest.getSize());
                    item.setSkirt(skirt);
                    break;
                case "shirt":
                    Shirt shirt = shirtRepository.findById(itemRequest.getUniformId())
                            .orElse(new Shirt());
                    shirt.setName(itemRequest.getName());
                    shirt.setColor(itemRequest.getColor());
                    shirt.setSize(itemRequest.getSize());
                    item.setShirt(shirt);
                    break;
                case "shorts":
                    Shorts shorts = shortsRepository.findById(itemRequest.getUniformId())
                            .orElse(new Shorts());
                    shorts.setName(itemRequest.getName());
                    shorts.setColor(itemRequest.getColor());
                    shorts.setSize(itemRequest.getSize());
                    item.setShorts(shorts);
                    break;
                default:
                    throw new RuntimeException("Unsupported uniform type");
            }

            item.setQuantity(itemRequest.getQuantity());
            item.setUniformReceipt(receipt);
            items.add(item);
        }

        receipt.setItems(items);
        UniformReceipt savedReceipt = uniformReceiptRepository.save(receipt);
        return ResponseEntity.ok(savedReceipt);
    }
}
