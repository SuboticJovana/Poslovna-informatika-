
insert into cities(city_id, ptt, city_name) values(1, 21000, "Novi Sad")

insert into enterprises(enterprise_id, nameEnterprise, address, phone, fax)  values(1, "Proizvodnja DOO", "Bulevar Oslobodjenja 12", "+381624995295", "")
--partner partners
insert into partners(partner_id, partner_name, address, phone_number, fax, email, type_of_partner, city_id, enterprise_id)  values(1, "partner", "Laze Nancica 1", "11111", "", "partner@gmail.com", 0, 1, 1)

insert into invoice(id, invoice_number, date_invoice, date_currency, total_base, total_pdv, total_amount, status, enterprise_id, partner_id)  values(1, 1,"2020-02-02", "2020-02-02",1,1,1,"waiting?", 1,1)
--service id
insert into invoice_items(id, quantity, discount, unit_price, PDV_base, PDV_amount, total_amount, invoice_id, service_id)  values(1, 1,10, 100, 100, 100, 10000, 1, 1)

insert into pdv_category(id, name)  values(1, "category1")

insert into pdv_rates(pdv_rate_id, percentage, date_of, pdv_category_id)  values(1, 10, "2020-03-03", 1 )

insert into pricelists(pricelist_id, date_from, date_to, percentage, total_price)  values(1, "2020-01-01", "2020-09-09", 10, 1000 )

insert into service_group(id, name, pdv_category_id, enterprise_id)  values(1,"service group",1,1 )

insert into unit_of_measure(id, name, short_name )  values(1,"name","short name" )

insert into services(service_id, name, description, goods,groupserv_id,unitmea_id )  values(1,"name",true, 1,1 )

insert into pricelists(price_list_item_id, price, pricelist_id, service_id)  values(1,100,1,1 )




