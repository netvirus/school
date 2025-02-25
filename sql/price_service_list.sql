<<<<<<< Local Changes
studentDto
 -> studentPricesDto
	-> id
	-> active
	-> gradeDTO
	-> priceDto
		-> priceServiceList
			-> schoolServiceList
	-> studentServiceList
		-> priceServiceList
			-> schoolServiceList
	-> paymentPeriod
	-> payment
			
INSERT INTO public.price_service_list (id, cost, price_id, school_service_list_id, price_service_list_id) VALUES (1, 100, 1, 1, 1);

helm --debug upgrade --install banks-bus nxs-universal-chart -n banks-bus-test --create-namespace -f test-to-prod.values.template.yaml

helm --debug uninstall banks-bus -n banks-bus-test||||||| Old File
studentPricesDto
	-> gradeDTO
		-> id
		-> name
		-> priceDto
			-> id
			-> name
			-> priceServiceList
			-> studentServiceList
			-> paymentPeriod
			
INSERT INTO public.price_service_list (id, cost, price_id, school_service_list_id, price_service_list_id) VALUES (1, 100, 1, 1, 1);

helm --debug template banks-bus nxs-universal-chart -f test-banks-bus.values.yaml
helm --debug upgrade --install banks-bus nxs-universal-chart -n banks-bus-test --create-namespace -f test-to-prod.values.template.yaml
helm --debug uninstall banks-bus -n banks-bus-test=======


Электронный ценик


