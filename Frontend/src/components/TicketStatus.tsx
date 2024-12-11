interface TicketStatusProps {
  total: number;
  max: number;
}

function TicketStatus({ total, max }: TicketStatusProps) {
  return (
    <div className="ticket-status">
      <h2>Ticket Pool Status</h2>
      <p>
        Available Tickets: {total} / {max}
      </p>
    </div>
  );
}

export default TicketStatus;
