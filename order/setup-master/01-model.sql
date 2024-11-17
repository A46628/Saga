DROP table if EXISTS public.sagalog;

CREATE TABLE public.sagalog (
	id char(36) NOT NULL,
	state int NOT NULL,
	orderinfo varchar(1024) NOT NULL,
	created_at timestamp WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT sagalog_pkey PRIMARY KEY (id)
);